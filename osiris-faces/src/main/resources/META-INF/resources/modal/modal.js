PrimeFaces.widget.Modal = PrimeFaces.widget.BaseWidget.extend({
	
	init: function(cfg) {
        this._super(cfg);

        this.cfg.minWidth = this.cfg.minWidth||150;
        this.cfg.minHeight = this.cfg.minHeight||80;
      
        var modal = $(this.jq[0]);  
        
        //size
        modal.css({
        	'min-width': this.cfg.minWidth,
        	'min-height': this.cfg.minHeight
        });
        
        if (this.cfg.minWidth) {
        	modal.css({
            	'width': this.cfg.width,
            });
        }
        
        var _self = this;
        
    	$(this.jq[0]).bind('hidden', function() {
    		_self.cfg.visible = false;
    		
    		if(_self.cfg.onClose) {
    			_self.cfg.onClose.call();
			}
    		
    		if(_self.cfg.behaviors) {
                var closeBehavior = _self.cfg.behaviors['close'];

                if(closeBehavior) {
                    closeBehavior.call(this);
                }
            }
    	});
        
        //Client Behaviors
        if(this.cfg.behaviors) {
            this.attachBehaviors(this.jq, this.cfg.behaviors);
        }
        
        if(this.cfg.visible) {
        	this.cfg.visible = false;
        	this.show();
        }
	},

	applyFocus: function() {
        this.jq.find(':not(:submit):not(:button):input:visible:enabled:first').focus();
    },
	
	attachBehaviors : function(element, behaviors) {
        $.each(behaviors, function(event, fn) {
            element.bind(event, function(e) {
                fn.call(element, e);
            });
        });
    },
	
	show: function() {
		if(!this.cfg.visible) {
			var backdrop = $('.modal-backdrop');
			
			if (backdrop != undefined) {
				backdrop.remove();
			}

			if(this.cfg.onOpen) {
				this.cfg.onOpen.call();
			}
			
			$(this.jq[0]).modal('show');
			this.cfg.visible = true;
			
			this.applyFocus();
		}
	},
	
	hide: function() {
		$(this.jq[0]).modal('hide');
	}
});