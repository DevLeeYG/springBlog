let index = {
    init:function (){
        $("#btn-save").on("click",()=>{
            this.save();
        });
    },
    save:function (){
        let data ={
            title:$("#title").val(),
            content:$("#content").val(),

        }
        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),//http body 데이터
            contentType:"application/json; charset=utf-8",


        }).done(function (res){
            alert("글쓰기가 완료되었습니다.")
            location.href="/";
        }).fail(function (err){
           alert(JSON.stringify(err))
        });

    },
}

index.init()