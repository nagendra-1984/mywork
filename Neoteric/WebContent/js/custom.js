if($.browser.mozilla||$.browser.opera ){document.removeEventListener("DOMContentLoaded",jQuery.ready,false);document.addEventListener("DOMContentLoaded",function(){jQuery.ready()},false)}
jQuery.event.remove( window, "load", jQuery.ready );
jQuery.event.add( window, "load", function(){jQuery.ready();} );
jQuery.extend({
	includeStates:{},
	include:function(url,callback,dependency){
		if ( typeof callback!='function'&&!dependency){
			dependency = callback;
			callback = null;
		}
		url = url.replace('\n', '');
		jQuery.includeStates[url] = false;
		var script = document.createElement('script');
		script.type = 'text/javascript';
		script.onload = function () {
			jQuery.includeStates[url] = true;
			if ( callback )
				callback.call(script);
		};
		script.onreadystatechange = function () {
			if ( this.readyState != "complete" && this.readyState != "loaded" ) return;
			jQuery.includeStates[url] = true;
			if ( callback )
				callback.call(script);
		};
		script.src = url;
		if ( dependency ) {
			if ( dependency.constructor != Array )
				dependency = [dependency];
			setTimeout(function(){
				var valid = true;
				$.each(dependency, function(k, v){
					if (! v() ) {
						valid = false;
						return false;
					}
				})
				if ( valid )
					document.getElementsByTagName('body')[0].appendChild(script);
				else
					setTimeout(arguments.callee, 10);
			}, 10);
		}
		else
			document.getElementsByTagName('body')[0].appendChild(script);
		return function(){
			return jQuery.includeStates[url];
		}
	},

	readyOld: jQuery.ready,
	ready: function () {
		if (jQuery.isReady) return;
		imReady = true;
		$.each(jQuery.includeStates, function(url, state) {
			if (! state)
				return imReady = false;
		});
		if (imReady) {
			jQuery.readyOld.apply(jQuery, arguments);
		} else {
			setTimeout(arguments.callee, 10);
		}
	}
})


/*
* Jquery Cookie
*/
jQuery.cookie=function(name,value,options){if(typeof value!='undefined'){options=options||{};if(value===null){value='';options.expires=-1}var expires='';if(options.expires&&(typeof options.expires=='number'||options.expires.toUTCString)){var date;if(typeof options.expires=='number'){date=new Date();date.setTime(date.getTime()+(options.expires*24*60*60*1000))}else{date=options.expires}expires='; expires='+date.toUTCString()}var path=options.path?'; path='+(options.path):'';var domain=options.domain?'; domain='+(options.domain):'';var secure=options.secure?'; secure':'';document.cookie=[name,'=',encodeURIComponent(value),expires,path,domain,secure].join('')}else{var cookieValue=null;if(document.cookie&&document.cookie!=''){var cookies=document.cookie.split(';');for(var i=0;i<cookies.length;i++){var cookie=jQuery.trim(cookies[i]);if(cookie.substring(0,name.length+1)==(name+'=')){cookieValue=decodeURIComponent(cookie.substring(name.length+1));break}}}return cookieValue}};

/* ---------------------------------------------------------------------- */
/*	Include Javascript Files
/* ---------------------------------------------------------------------- */

$.include('js/jquery.easing.1.3.js')

if($('.single-image').length) {
	$.include('fancybox/jquery.fancybox.pack.js');
}

if($('#gallery').length) {
	$.include('js/jquery.isotope.min.js');
}

if($('.testimonials').length || $('.image-gallery-slider').length) {
	$.include('js/jquery.cycle.all.min.js');	
}

if($('.twitter-widget').length) {
	$.include('js/jquery.tweet.js');
}

/* Panel --> Begin */
$.include('themeChanger/js/colorpicker.js')
$.include('themeChanger/js/themeChanger.js')
/* Panel --> End */


// Load Google Fonts
WebFontConfig = {
	google: {
		families: [ 'Arimo', 'Anton', 'Crushed', 'Francois One', 'Lobster', 'Oswald', 'Pacifico']
	}
};
(function() {
	var wf = document.createElement('script');
	wf.src = ('https:' == document.location.protocol ? 'https' : 'http') +
	'://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
	wf.type = 'text/javascript';
	wf.async = 'true';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(wf, s);
})();

/************************************************************************/
/* DOM READY --> Begin													*/
/************************************************************************/

jQuery(document).ready(function($){
	
/* ---------------------------------------------------------------------- */
/*	Nivo Slider
/* ---------------------------------------------------------------------- */	
	
if ($('.nivoSlider').length) {
	$(window).load(function(){
		$('.nivoSlider').nivoSlider({pauseTime: 5000});
	});
}
 
/* end Nivo Slider */
 
/* ---------------------------------------------------------------------- */
/*	Circle Effect Slider
/* ---------------------------------------------------------------------- */

if($('#cn-slideshow').length) {
	$('#cn-slideshow').slideshow();
} 

/* end Circle Effect Slider */

/* ---------------------------------------------------------------------- */
/*	Accordion Slider
/* ---------------------------------------------------------------------- */

if ($('#accordion').length) {
	$(function() {
		$('#accordion').eAccordion({
			easing: 'swing',                // Anything other than "linear" or "swing" requires the easing plugin
			autoPlay: true,                 // This turns off the entire FUNCTIONALY, not just if it starts running or not
			startStopped: false,            // If autoPlay is on, this can force it to start stopped
			stopAtEnd: false,				// If autoplay is on, it will stop when it reaches the last slide
			delay: 3000,                    // How long between slide transitions in AutoPlay mode
			animationTime: 600,             // How long the slide transition takes
			hashTags: true,                 // Should links change the hashtag in the URL?
			pauseOnHover: false,             // If true, and autoPlay is enabled, the show will pause on hover
			width: null,					// Override the default CSS width
			height: null,					// Override the default CSS height
			expandedWidth: '390px'			// Width of the expanded slide
		});
	});
}

 /* end Accordion Slider */
 
 /* ---------------------------------------------------------------------- */
/*	Rama Slider
/* ---------------------------------------------------------------------- */

if($('#example').length) {
	$('#example').frames_slider({
			width: 912,
			height: 390,
			theme: "sport",
			hidetoolbar: 6000
		})
	}
	
 /* end Rama Slider */
	 
 /* ---------------------------------------------------------------------- */
/*	Mosaic
/* ---------------------------------------------------------------------- */

if ($('#mosaic').length) {
	$.imJQMosaic({
		image:'images/sliders/example.jpg',
		target: 'mosaic',
		frameWidth: '914',
		frameHeight: '390',
		numberOfTilesX: '16',
		numberOfTilesY: '7',
		tileBorder: '1',
		tileBorderColor: '#ccc',
		tileBorderRadius: '1',
		effectIntensity: '0.6',
		effectColor: '#c6e346'
	});
}

 /* end Mosaic */
 
/* ---------------------------------------------------------------------- */
/*	Placeholder
/* ---------------------------------------------------------------------- */

(function() {

	$.fn.placeholder = function() {
		if(typeof document.createElement("input").placeholder == 'undefined') {
			$('[placeholder]').focus(function() {
				var input = $(this);
				if (input.val() == input.attr('placeholder')) {
					input.val('');
					input.removeClass('placeholder');
				}
			}).blur(function() {
				var input = $(this);
				if (input.val() == '' || input.val() == input.attr('placeholder')) {
					input.addClass('placeholder');
					input.val(input.attr('placeholder'));
				}
			}).blur().parents('form').submit(function() {
				$(this).find('[placeholder]').each(function() {
					var input = $(this);
					if (input.val() == input.attr('placeholder')) {
						input.val('');
					}
				})
			});
		}
	}

	$.fn.placeholder();

})();

/* end Placeholder */

/* ---------------------------------------------------------------------- */
/*	Search
/* ---------------------------------------------------------------------- */
	
(function() {
	
		var trigger = $('.search-tooltip-trigger'),
			tooltip = $('.search-tooltip > form'),
			field = tooltip.find('input[type="text"]');
	
	trigger.on('mouseenter', function() {
		$('body,html').animate({
			scrollTop : 0
		}, 200);
		tooltip.stop(true,false).animate({opacity : 1}, 350).show(200).queue(function() {
			field.focus();
		});
	});
	tooltip.on('mouseleave', function() {
		tooltip.stop(true,false).animate({opacity : 0}, 600);
	});	

})();

/* end Search */

/* ---------------------------------------------------------------------- */
/*	Fancybox
/* ---------------------------------------------------------------------- */

(function() {

	if($('.single-image').length || $('a.video').length)  {
		(function() {
			$('.single-image, a.video').fancybox({
				'titlePosition' : 'over',
				'transitionIn'  : 'fade',
				'transitionOut' : 'fade'
			}).each(function() {
				$(this).append('<span class="curtain">&nbsp;</span>');
			});		
		})();

		(function() {
			$('a.video').on('click',function() {
				$.fancybox({
					'type' : 'iframe',
					'href' : this.href.replace(new RegExp('watch\\?v=', 'i'), 'embed/index.html') + '&autoplay=1',
					'overlayShow' : true,
					'centerOnScroll' : true,
					'speedIn' : 100,
					'speedOut' : 50,
					'width' : 640,
					'height' : 480
				});
				return false;
			});
		})();
	}

})();

/* end fancybox --> End */

/* ---------------------------------------------------------------------- */
/*	Toggle
/* ---------------------------------------------------------------------- */

(function() {

	if($('.toggle-container').length) {	
		$(".toggle-container").hide(); //Hide (Collapse) the toggle containers on load
		//Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
		$(".trigger").click(function(){
			$(this).toggleClass("active").next().slideToggle("slow");
			return false; //Prevent the browser jump to the link anchor
		});
	}

})();

/* end Toggle */

/* ---------------------------------------------------------------------- */
/*	Accordion
/* ---------------------------------------------------------------------- */

(function() {

	if($('.acc-container').length) {

		var $container = $('.acc-container'),
			$trigger   = $('.acc-trigger');

		$container.hide();
		$trigger.first().addClass('active').next().show();

		var fullWidth = $container.outerWidth(true);
		$trigger.css('width', fullWidth);
		$container.css('width', fullWidth + 2);

		$trigger.on('click', function(e) {
			if( $(this).next().is(':hidden') ) {
				$trigger.removeClass('active').next().slideUp(300);
				$(this).toggleClass('active').next().slideDown(300);
			}
			e.preventDefault();
		});

		// Resize
		$(window).on('resize', function() {
			fullWidth = $container.outerWidth(true)
			$trigger.css('width', $trigger.parent().width() );
			$container.css('width', $container.parent().width() + 2 );
		});
	}

})();

/* end Accordion */

/* ---------------------------------------------------------------------- */
/*	Tabs
/* ---------------------------------------------------------------------- */

(function() {

	if($('.content-tabs').length) {

		var $tabsStyle1  = $('.content-tabs.tabs-style-1');
		var $tabsStyle2  = $('.content-tabs.tabs-style-2');
		var $tabsStyle3  = $('.content-tabs.tabs-style-3');

		$.fn.tabs = function($obj) {
				$tabsNavLis = $obj.find('.tabs-nav').children('li'),
				$tabContent = $obj.find('.tab-content');

			$tabContent.hide();	
			$tabsNavLis.first().addClass('active').show();
			$tabContent.first().show();

			$obj.find('ul.tabs-nav li').on('click', function(e) {
				var $this = $(this);

				$obj.find('ul.tabs-nav li').removeClass('active');
				$this.addClass('active');
				$obj.find('.tab-content').hide(); //Hide all tab content
				$($this.find('a').attr('href')).fadeIn();

				e.preventDefault();
			});
		}

			$tabsStyle1.tabs($tabsStyle1);
			$tabsStyle2.tabs($tabsStyle2);
			$tabsStyle3.tabs($tabsStyle3);
	}

})();

/* end Tabs */

/* ---------------------------------------------------------------------- */
/*	Google Maps
/* ---------------------------------------------------------------------- */

(function() {

	if($('#map').length) {
		$('#map').gMap({ 
			address: 'New York, USA',
			zoom: 14,
			markers: [
				{'address' : 'Grand St, New York'}
			]
		});  
	}

})();

/* end Google Maps */

/* ---------------------------------------------------------------------- */
/*	Contact Form
/* ---------------------------------------------------------------------- */

(function() {

	if($('#contactform').length) {

		var $form = $('#contactform'),
		$loader = '<img src="images/preloader.gif" alt="Loading..." />';
		$form.append('<div class="hidden" id="contact_form_responce">');

		var $response = $('#contact_form_responce');
		$response.append('<p></p>');

		$form.submit(function(e){

			$response.find('p').html($loader);

			var data = {
				action: "contact_form_request",
				values: $("#contactform").serialize()
			};

			//send data to server
			$.post("php/contact-send.html", data, function(response) {

				response = $.parseJSON(response);
				
				$(".wrong-data").removeClass("wrong-data");
				$response.find('img').remove();

				if(response.is_errors){

					$response.find('p').removeClass().addClass("error");
					$.each(response.info,function(input_name, input_label) {

						$("[name="+input_name+"]").addClass("wrong-data");
						$response.find('p').append('Please enter correctly "'+input_label+'"!'+ '</br>');
					});

				} else {

					$response.find('p').removeClass().addClass('success');

					if(response.info == 'success'){

						$response.find('p').append('Your email has been sent!');
						$form.find('input:not(input[type="submit"], button), textarea, select').val('').attr( 'checked', false );
						$response.delay(1500).hide(400);
					}

					if(response.info == 'server_fail'){
						$response.find('p').append('Server failed. Send later!');
					}
				}

				// Scroll to bottom of the form to show respond message
				var bottomPosition = $form.offset().top + $form.outerHeight() - $(window).height();

				if($(document).scrollTop() < bottomPosition) {
					$('html, body').animate({
						scrollTop : bottomPosition
					});
				}
				
				if(!$('#contact_form_responce').css('display') == 'block') {
					$response.show(450);
				}
			
			});

			e.preventDefault();

		});				

	}

})();

/* end Contact Form */
 
/* ---------------------------------------------------------------------- */
/*	Back to Top
/* ---------------------------------------------------------------------- */

(function() {

	var extend = {
			button      : '#back-top',
			backToTop	: '.divider-to-top a',
			text        : 'Back to Top',
			min         : 200,
			fadeIn      : 400,
			fadeOut     : 400,
			speed		: 800,
			easing		: 'easeOutQuint'
		}

	$('body').append('<a href="#" id="' + extend.button.substring(1) + '" title="' + extend.text + '">' + extend.text + '</a>');

	$(window).scroll(function() {
		var pos = $(window).scrollTop();

		if (pos > extend.min) {
			$(extend.button).fadeIn(extend.fadeIn);
		}
		else {
			$(extend.button).fadeOut (extend.fadeOut);
		}

	});

	$(extend.button).add(extend.backToTop).click(function(e){
		$('html, body').animate({scrollTop : 0}, extend.speed, extend.easing);
		e.preventDefault();
	});

})();

/* end Back to Top */

/* ---------------------------------------------------------------------- */
/*	Cycle
/* ---------------------------------------------------------------------- */
	
(function() {
	
	// Testimonials
	var $quotes = $(".testimonials ul");
	
	if($quotes.length) {

		$quotes.each(function(i) {
			var $this = $(this);

			$this.cycle({
				before: function(curr, next, opts) {
					var $this = $(this);
					$this.parent().stop().animate({
						height: $this.height()
					}, opts.speed);
				},
				containerResize : false,
				easing          : 'easeInOutExpo',
				fx              : 'fade',
				fit             : true,
				pause           : true,
				slideExpr       : 'li',
				slideResize     : true,
				speed           : 600,
				timeout         : 4000,
				width           : '100%'
			});
		});
	}
	
	// Portfolio Single Page
	var $slider = $('.image-gallery-slider');
	
		if ($slider.length) {
		
			$slider.each(function() {
				
				var $this = $(this);
				
				$this.cycle({
					fx:     'scrollHorz', 
					timeout: 0, 
					next:   '.buttons .next',
					prev:   '.buttons .prev',
					easing: 'easeInBack'
				});
			})
		}
	
})();

/* end Cycle */

/* ---------------------------------------------------------------------- */
/*	 Custom
/* ---------------------------------------------------------------------- */

(function() {
	
	var client = $('ul.client-list');
		client.find('li:nth-child(4n+1)').css('border-left','none');
		client.find('li').slice(0,4).css('border-top','none');
		
	if($.browser.msie && $.browser.version < 9) {
		if($('#portfolio-items').length) {
			$('#portfolio-items.gl-col-2 > article:nth-child(2n)').css('margin-right','0');
			$('#portfolio-items.gl-col-3 > article:nth-child(3n)').css('margin-right','0');
			$('#portfolio-items.gl-col-4 > article:nth-child(4n)').css('margin-right','0');		
		}
	}		
	
})();
		
/* end Custom */

/* ---------------------------------------------------- */
/*	Min. Height
/* ---------------------------------------------------- */

//(function() {
//
//	$('section.container')
//		.css( 'min-height', $(window).outerHeight(true) 
//			- $('#header').outerHeight(true)
//			- $('.breadcrumbs').outerHeight(true)
//			- $('#footer').outerHeight(true));
//})();

/* end Min. Height */

/* ---------------------------------------------------- */
/*	Slider Pay
/* ---------------------------------------------------- */

(function(){
  
  var plans = {
			us: [], 
			eu: []
		}
		plans.max_encoders = 9
  
		for(var i = 1; i < 10; i++){
			plans.us.push({
				num_encoders: i, 
				pounds_per_month: i*99
				});
			plans.eu.push({
				num_encoders: i, 
				pounds_per_month: i*109
				});
		}

		$.fn.customOption = function(options) {
			var region_options = $(this)
			$("label").click(function () {
				$(region_options).find("label").removeClass("selected");
				$(this).addClass("selected");
				options.handler(this)
			});
		}
  
		if ($("#eu_price").length == 0) {
			return;
		}
  
		$("#eu_price").closest("div").hide()
    
		$("#region-radiobox").customOption(
		{
			handler: function(label){
				if($(label).attr("id") == "us-price-option") {
					$("#us_price").closest("div").show()
					$("#eu_price").closest("div").hide()
				}else if($(label).attr("id") == "eu-price-option") {
					$("#us_price").closest("div").hide()
					$("#eu_price").closest("div").show()
				}
			}
		})
    
	$('#slider-pay').slider({
		value:0,
		min: 0,
		max: plans.max_encoders -1,
		step: 1
	}).bind('slide', function(evt, ui){
		var us_plan = plans.us[ui.value];
		var eu_plan = plans.eu[ui.value];
      
		$(this).find('.ui-slider-handle').html(us_plan.num_encoders);
      
		$('#us_price').html(us_plan.pounds_per_month);
		$('#eu_price').html(eu_plan.pounds_per_month);
      
		var plan_button = $('#plan-button-' + (ui.value + 1));
		plan_button.prevAll().hide();
		plan_button.show();
		plan_button.nextAll().hide();
      
	}).find('.ui-slider-handle').html(1);

})();

/* end Slider Pay */

/* ---------------------------------------------------------------------- */
/*	 Gallery
/* ---------------------------------------------------------------------- */	

(function() {

	var $cont = $('#gallery');

	if($cont.length) {

		var $itemsFilter = $('#portfolio-filter'),
			mouseOver;

		// Copy categories to item classes
		$('article', $cont).each(function(i) {
			var $this = $(this);
			$this.addClass($this.attr('data-categories'));
		});

		// Run Isotope when all images are fully loaded
		$(window).on('load', function() {

			$cont.isotope({
				itemSelector : 'article',
				layoutMode   : 'fitRows'
			});

		});

		// Filter projects
		$itemsFilter.on('click', 'a', function(e) {
			var $this         = $(this),
				currentOption = $this.attr('data-categories');

			$itemsFilter.find('a').removeClass('active');
			$this.addClass('active');

			if(currentOption) {
				if(currentOption !== '*') currentOption = currentOption.replace(currentOption, '.' + currentOption)

				$cont.isotope({filter : currentOption});
			}

			e.preventDefault();
		});

		$itemsFilter.find('a').first().addClass('active');
	}

})();
	
/* ------------------------------------------------------------------- */
/*	WorkPanel														   */
/* ------------------------------------------------------------------- */

(function() {

	var topPanelHidden=true,
		topPanelShowing,
		hasClosed;

	$.fn.workPanel = function(params){
		var conf = $.extend({
			blockPanel: '#workPanel'
		}, params);
		return this.each(function(){
			var o=$(this), c=conf, targetPane=o.attr('href'), panel=$(c.blockPanel);
			o.bind('click', function(){
				if(topPanelHidden != true){
					o.removeClass('selected');
					panel.stop().animate({
						height: '0px',
						opacity: 0
					},500);
					$('.workPanelContent').fadeOut(500);
					$('body, html').stop().animate({
						scrollTop: panel.offset().top
					}, 1000);
					hasClosed = true;
				}

				if(topPanelShowing != targetPane || topPanelHidden == true) {
					topPanelShowing=targetPane;
					o.addClass('selected');
					$('div'+targetPane).animate({
						opacity:1
					}, 500, function(){	
						$('div' + targetPane).fadeIn(500);
					});
					panel.stop().animate({
						height:'550px',
						opacity:1
					},500).show();
					$('body, html').stop().animate({
						scrollTop: panel.offset().top
					}, 1000);
					hasClosed=false;
				}
				topPanelHidden = hasClosed;
				return false;
			});
		});
	}

	if($('.workPanelLink').length) {
		$('.workPanelLink').workPanel();
	}

})();

/* end WorkPanel */

/* ---------------------------------------------------------------------- */
/*	Twitter
/* ---------------------------------------------------------------------- */

(function(){

	if($('.twitter-widget').length) {
		$(".twitter-widget").tweet({
			username: "ThemeMakers",
			page: 1,
			avatar_size: 0,
			count: 1,
			loading_text: "loading ..."
		}).bind("loaded", function() {
			var ul = $(this).find(".tweet-list");
		});		
	}

})();

/* end Twitter */

/************************************************************************/
});/* DOM READY --> End													*/
/************************************************************************/




	
	 