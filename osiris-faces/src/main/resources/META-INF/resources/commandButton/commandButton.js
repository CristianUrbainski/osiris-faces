PrimeFaces.widget.BootstrapCommandButton = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
    },
    
    disable: function() {
        this.jq.addClass('disabled').attr('disabled', 'disabled');
    },
    
    enable: function() {
        this.jq.removeClass('disabled').removeAttr('disabled');
    }
    
});