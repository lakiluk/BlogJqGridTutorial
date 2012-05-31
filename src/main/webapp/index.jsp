<html>
<head>
    <link type="text/css" href="js/jqgrid/css/ui.jqgrid.css" rel="stylesheet"/>
    <link type="text/css" href="css/redmond/jquery-ui-1.8.20.custom.css" rel="stylesheet">

    <script src="js/jqgrid/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"></script>
    <script src="js/jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="js/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            $("#grid").jqGrid({
                url:'OrderProvider',
                datatype: 'json',
                mtype: 'POST',
                height: "auto",
                colNames:['Order Id','User Id', 'Price','Invoice number'],
                colModel :[
                    {width:100,align:'center', sortable:false},
                    {width:100, align:'center', sortable:false},
                    {width:100, align:'center', sortable:false},
                    {width:500, align:'center', sortable:false}
                ],
                rowNum:10,
                rowList:[10,20,30],
                pager:'#pager',
                caption: 'Order grid'
            });
        });
    </script>

</head>
<body>

<table id="grid"><tr><td/></tr></table>
<div id="pager"></div>
</body>
</html>
