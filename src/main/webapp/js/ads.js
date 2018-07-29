 $(function () {
        let url="ads";
        let method="GET";
        let headers=[{"key":"Content-Type","value":"application/json"}];

        //渲染表格
        function renderTable(ads) {
            let table=document.querySelector("#ads");
            for(let i=0;i<ads.length;i++){
                let tr=$("<tr>");
                $("<td>").text(ads[i].shopName).appendTo(tr);
                let imgtd=$("<td>");
                imgtd.appendTo(tr);
                $("<img>").attr("src",ads[i].picture).attr("alt","picture").attr("width","45px").attr("height","40px").appendTo(imgtd);
                $("<td>").text(ads[i].slogan).appendTo(tr);
                $("<td>").text(ads[i].price).appendTo(tr);
                let td1=$("<td>");
                let td2=$("<td>");
                let td3=$("<td>");
                $("<button>").text("上架").addClass("btn btn-success").on("click",function () {
                    changeState(ads[i].id,1);
                }).appendTo(td1);
                $("<button>").text("下架").addClass("btn btn-danger").on("click",function () {
                	changeState(ads[i].id,0);
                }).appendTo(td2);
                $("<button>").text("删除").addClass("btn btn-danger").on("click",function () {
                	delAd(ads[i].id);
                }).appendTo(td3);
                if(ads[i].state==0){
                	 $("<td>").text("下架").appendTo(tr);
	                td1.appendTo(tr);
                }else{
                    $("<td>").text("上架").appendTo(tr);
    	            td2.appendTo(tr);
                }
                td3.appendTo(tr);
                tr.attr("id",ads[i].id).addClass("datas").appendTo(table);
            }
        }
        
        //获取数据
        function getData(method,url,data,headers){
            $.ajax({
                type: method,
                url: url,
                data:"currentPage="+$("#currentPage").val()+"&pageSize="+$("#pageSize").val(),
                dataType:"json",
                success: function(data){
                	makePage(data);
                    renderTable(data.dataList);
                }
            });
        }
      
        getData(method,url,null,headers);
        
        //改变状态
        function changeState(id,state) {
            $.ajax({
                type:'GET',
                url:'adagree',
                data:'id='+id+"&state="+state,
                success(){
                	$(".datas").remove();
                	 getData(method,url,null,headers);
                }
            })
        }
        
        //删除广告
       	function delAd(id){
       		$.ajax({
                type:'GET',
                url:'deletead',
                data:'id='+id,
                success(){
                	$(".datas").remove();
                	getData(method,url,null,headers);
                }
            })
       	}
       	
       	//渲染页数
       	function makePage(data){
	       	 let totalPage=data.totalPage;
	    	 let totalCount=data.totalCount;
	    	 $(".pagination").remove();
	    	 let page=$("#page");
			let ul=$("<ul>").addClass("pagination");
			ul.appendTo(page);
			let li1=$("<li>").addClass("lis").appendTo(ul);
	        let a1=$("<a>").attr("href","#").attr("aria-label","Previous").appendTo(li1);
	        $("<span>").attr("aria-hidden","true").text("首页").appendTo(a1);
	    	 for(let i=0;i<totalPage;i++){
	    		 let li=$("<li>").addClass("lis");
	    		 $("<a>").attr("href","#").text(i+1).appendTo(li);
	    		 li.appendTo(ul);
	    	 }
	    	 let li2=$("<li>").addClass("lis").appendTo(ul);
	         let a2=$("<a>").attr("href","#").attr("aria-label","Previous").appendTo(li2);
	         $("<span>").attr("aria-hidden","true").text("尾页").appendTo(a2)
	    	 $("#totalPage").text(data.totalPage);
	    	 $("#totalCount").text(data.totalCount);
	    	 $(".lis").on("click",function(){
	    		 if($(this).text()=="首页"){
	    				 $("#currentPage").val(1);
	    			 }else if($(this).text()=="尾页"){
	    				 $("#currentPage").val(totalPage);
	    			 }else{
	    				 $("#currentPage").val($(this).text());
	    			 }
	    		 $(".datas").remove();
	    		 getData(method,url,data,headers);
	    	 })
       	}
       	
       	//改变每页显示的数据数
        $("#pageSize").on("blur",function () {
        	$(".datas").remove();
        	getData(method,url,null,headers);
        })
       	
    })
