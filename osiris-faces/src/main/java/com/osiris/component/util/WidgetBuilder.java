package com.osiris.component.util;

public class WidgetBuilder {

	protected StringBuilder buffer;
    
    protected boolean onload = false;
    
    protected String resourcePath = null;
        
    public WidgetBuilder() {
        buffer = new StringBuilder();
    }
    
    /**
     *
     * @param widgetClass   Constructor name of the widget
     * @param widgetVar     Name of the client side widget
     * @param id            Client id of the component
     * @param onload        Flag to define if widget should be created on document load
     */
    public WidgetBuilder widget(String widgetClass, String widgetVar, String id, boolean onload) {
        this.onload = onload;
        if(this.onload) {
            buffer.append("$(function(){");
        }
        
        buffer.append("PrimeFaces.cw('").append(widgetClass).append("','").append(widgetVar).append("',{");
        buffer.append("id:'").append(id).append("'");
        
        return this;
    }
    
    /**
     *
     * @param widgetClass   Constructor name of the widget
     * @param widgetVar     Name of the client side widget
     * @param id            Client id of the component
     * @param resourcePath  Path for dynamic resource loading
     * @param onload        Flag to define if widget should be created on document load
     */
    public WidgetBuilder widget(String widgetClass, String widgetVar, String id, String resourcePath, boolean onload) {
        this.widget(widgetClass, widgetVar, id, onload);
        this.resourcePath = resourcePath;
        
        return this;
    }
    
    public WidgetBuilder attr(String name, String value) {
        buffer.append(",").append(name).append(":'").append(value).append("'");
        
        return this;
    }
    
    public WidgetBuilder nativeAttr(String name, String value) {
        buffer.append(",").append(name).append(":").append(value);
        
        return this;
    }
    
    public WidgetBuilder attr(String name, boolean value) {
        buffer.append(",").append(name).append(":").append(value);
        
        return this;
    }
    
    public WidgetBuilder attr(String name, Number value) {
        buffer.append(",").append(name).append(":").append(value);
        
        return this;
    }
        
    public WidgetBuilder attr(String name, String value, String defaultValue) {
        if(value != null && !value.equals(defaultValue)) {
            buffer.append(",").append(name).append(":'").append(value).append("'");
        }
        
        return this;
    }
    
    public WidgetBuilder attr(String name, double value, double defaultValue) {
        if(value != defaultValue) {
            buffer.append(",").append(name).append(":").append(value);
        }
        
        return this;
    }
    
    public WidgetBuilder attr(String name, int value, int defaultValue) {
        if(value != defaultValue) {
            buffer.append(",").append(name).append(":").append(value);
        }
        
        return this;
    }
        
    public WidgetBuilder attr(String name, boolean value, boolean defaultValue) {
        if(value != defaultValue) {
            buffer.append(",").append(name).append(":").append(value);
        }
        
        return this;
    }
    
    public WidgetBuilder callback(String name, String signature, String callback) {
        if(callback != null) {
            buffer.append(",").append(name).append(":").append(signature).append("{").append(callback).append("}");
        }
        
        return this;
    }
        
    public WidgetBuilder append(String str) {
        buffer.append(str);
        
        return this;
    }
    
    public WidgetBuilder append(Number number) {
        buffer.append(number);
        
        return this;
    }

    public String build() {
        buffer.append("}");
        
        if(this.resourcePath != null) {
            buffer.append(",'").append(this.resourcePath).append("'");
        } 
        
        buffer.append(");");
        
        if(this.onload) {
            buffer.append("});");
        }
        
        String script = buffer.toString();
        
        reset();
        
        return script;
    }
    
    public void reset() {
        buffer.setLength(0);
        onload = false;
        resourcePath = null;
    }
    
}
