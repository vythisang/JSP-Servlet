<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
		<link rel="stylesheet" href="Template/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="Template/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<link rel="stylesheet" href="Template/assets/css/fonts.googleapis.com.css" />

		<link rel="stylesheet" href="Template/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<link rel="stylesheet" href="Template/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="Template/assets/css/ace-rtl.min.css" />

		<script src="Template/assets/js/ace-extra.min.js"></script>


</head>
<body class="no-skin">
	<!-- header -->
	<jsp:include page="../Header.jsp"   />
	<!-- /header -->
	
	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
		</script>
		<!-- menu -->
		<jsp:include page="../Menu.jsp"   />
		<!-- /menu -->
		
		
		<!-- maincontent -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="HomeForward">Home</a>
							</li>
							
						</ul>

				</div>
			
				<div class="page-content">
					<div class="page-header">
							<h1>
								Hi you! Welcome you to book store.
										
							</h1>
					</div>
				</div>
						
				<!-- content -->
				
				<div class="hr hr-18 dotted hr-double"></div>	
					<div class="row">
						<div class="col-xs-12">							
							<div class="row">
								<div class="col-xs-12">
									<table id="simple-table" class="table  table-bordered table-hover">
										<thead>
												<tr>
													<th class="center">
														ID
													</th>
													<th class="center">
														Name 
													</th>
													
													<th class="center">
														Modify
													</th>
													
													<th class="center">
														Delete
													</th>
													
													
												</tr>
											</thead>
											<thead>
												<c:forEach items="${categoryList}" var ="category">
												
													<tr>
													<th class="center">
														${category.id}
													</th>
													<th class="center">
														${category.name}
													</th>
													
													<th>
														<form action="ModifyCategory" method="post">
															
															<input type="hidden" name="id" value="${category.id}" />
															<button class="btn btn-xs btn-info" type="submit">
																<i class="ace-icon fa fa-pencil bigger-120"></i>
															</button>
														</form>
													</th>
													
													<th>
														<form action="CategoryForward" method="get">
															<input type="hidden" name="command" value="DELETE" />
															<input type="hidden" name="id" value="${category.id}" />
															<button class="btn btn-xs btn-danger" type="submit">
																<i class="ace-icon fa fa-trash-o bigger-120"></i>
															</button>
														</form>	
													</th>
													
												</tr>
												
												</c:forEach>
											</thead>


									</table>
								</div>
							</div>

						</div>
					</div>
				
				
				<!-- content -->
				
			
			</div>
		</div>
	<!-- /maincontent -->
		
		
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
		<script src="Template/assets/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='Template/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="Template/assets/js/bootstrap.min.js"></script>
		<script src="Template/assets/js/jquery-ui.custom.min.js"></script>
		<script src="Template/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="Template/assets/js/jquery.easypiechart.min.js"></script>
		<script src="Template/assets/js/jquery.sparkline.index.min.js"></script>
		<script src="Template/assets/js/jquery.flot.min.js"></script>
		<script src="Template/assets/js/jquery.flot.pie.min.js"></script>
		<script src="Template/assets/js/jquery.flot.resize.min.js"></script>

		<script src="Template/assets/js/ace-elements.min.js"></script>
		<script src="Template/assets/js/ace.min.js"></script>

		<script type="text/javascript">
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: ace.vars['old_ie'] ? false : 1000,
						size: size
					});
				})
			
				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html',
									 {
										tagValuesAttribute:'data-values',
										type: 'bar',
										barColor: barColor ,
										chartRangeMin:$(this).data('min') || 0
									 });
				});
			
			  $.resize.throttleWindow = false;
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);

			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);
			
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;
			
			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}
				
			 });
			
				/////////////////////////////////////
				$(document).one('ajaxloadstart.page', function(e) {
					$tooltip.remove();
				});
			
			
				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}
			
				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}
			
				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}
				
			
				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});
			
			
				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			
				$('.dialogs,.comments').ace_scroll({
					size: 300
			    });
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if(ace.vars['touch'] && ace.vars['android']) {
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				  });
				}
			
				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});
			
				$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
					var offset = $(this).offset();
			
					var $w = $(window)
					if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
						$(this).addClass('dropup');
					else $(this).removeClass('dropup');
				});
			
			})
		</script>
</body>
</html>