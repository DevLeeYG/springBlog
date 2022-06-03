let index = {
    init:function (){
        $("#btn-save").on("click",()=>{
            this.save();
        });
    },
    save:function (){
        let data ={
            username:$("#username").val(),
            password:$("#password").val(),
            email:$("#email").val()
        }
        $.ajax({
            type:"POST",
            url:"/auth/joinProc",
            data:JSON.stringify(data),//http body 데이터
            contentType:"application/json; charset=utf-8",
            //dataType:"json"//응답이 왔을때  기본적으로 문자열(생긴게 json이라면)-> js 오브젝트로 변환해줌

        }).done(function (res){
            alert("회원가입이 완료되었습니다")
            location.href="/";
        }).fail(function (err){
           alert(JSON.stringify(err))
        });//통신을 통해서 3개의 데이터를 json으로 변경해 insert요청

    },
}

index.init()