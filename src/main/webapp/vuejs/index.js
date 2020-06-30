new Vue({
    el:"#app",
    data:{
        list:[],
        cids:[],
        entity:{user:{},addresss:[]},
        pojo:{admin:{}},
        prolist:[],
        email:{},
        username:'',
        userage:''
    },
    methods:{

        code:function(){
          var _this = this;
          setTimeout(function () {
              document.getElementById("codeTel").innerHTML="获取验证码("+_this.timeout+"s)";
                _this.timeout = _this.timeout-1;
                if(_this.timeout>0){
                    _this.code();
                }
          },1000);
          if(_this.timeout == 1){
              document.getElementById("codeTel").disable = true;
              document.getElementById("codeTel").innerHTML = "获取验证码";
          }
        },
        getTel:function(){
            var _this = this;
            var el = /^\d{11}$/;
            if(!el.test(this.pojo.phon)){
                alert("请输入正确格式的手机号");
            }else{
                axios.get('/admin/getTel.do?phon='+_this.pojo.phon).then(function (result) {
                    if(result.data.flag){
                        alert(result.data.msg);
                        document.getElementById("codeTel").disable = false;
                        _this.code();
                    }else{
                        alert(result.data.msg);
                    }
                })
            }
        },
        register:function(){
            var _this = this;
            axios.post('register.do',_this.pojo).then(function (response) {
                if(response.data!=null){
                    alert("注册成功，为您跳转登录页面");
                    location.href="login.html";
                }else{
                    alert("注册失败，请重新注册");
                }
            });
        },
        getLogin:function(){
            var _this = this;
            var name = encodeURIComponent(encodeURIComponent(this.$refs.name.value));
            // var name = this.$refs.name.value;
            var password = this.$refs.password.value;
            axios.get('getLogin.do?name='+name+"&password="+password).then(function (result) {
                if(result.data.flag){
                    alert(result.data.msg);
                    location.href="index.html";
                }else {
                    alert(result.data.msg);
                }
            })
        },
        sendEmail:function(){
            // var em = this.$refs.MyEMAIL.value;
            alert(1111111);
        },
        emailSender:function(){
            document.getElementById("div4").style.display="block";
        },
        findOne:function(userid){
            var _this = this;
            axios.get('findOne.do?userid='+userid).then(function (response) {
                _this.entity = response.data;
                document.getElementById("div3").style.display="block";
            });
        },
        saveuser:function(){
            var _this = this;
            axios.post('saveOrUpdate.do',_this.entity).then(function (response) {
                if(response.data.flag){
                    _this.findAll();
                    document.getElementById("div3").style.display="none";
                }else{
                    alert(response.data.msg);
                }
            });
        },
        changecity:function(id,index){
            var _this = this;
            axios.get('getCityListById.do?id='+id).then(function (response) {
                _this.entity.addresss[index].coulist=response.data;
            });
        },
        changpro:function(id,index){
            /**
             * id。就是选择好的省的id
             * index能拿到是地址的集合里面的那个地址的，拿到选择的id
             */

            var _this = this;
            this.entity.addresss[index].citylist=[];
            axios.get('getCityListById.do?id='+id).then(function (response) {
                _this.entity.addresss[index].citylist=response.data;
                _this.entity.addresss[index].coulist=[];
            });

        },
        getProList:function(){
          var _this = this;
          axios.get('getCityListById.do?id=1').then(function (result) {
              _this.prolist=result.data;
          })
        },
        revoAddressRow:function(index){
            this.entity.addresss.splice(index,1);
        },
        addAddressRows:function(){
            this.entity.addresss.push({citylist:[],coulist:[]});
        },
        addUser:function(){
            document.getElementById("div3").style.display="block";
            // this.$refs.div3.style.display="block";
        },
        findAll:function () {
            var _this = this;
            axios.get('findAll.do').then(function (result) {
                _this.list = result.data;
            });
        },
        delAll:function () {
            if(this.cids.length>=1){
                if(window.confirm("确定删除"+this.cids+"吗?")){
                    var _this = this;
                    axios.post('delUserById.do',_this.cids).then(function (result) {
                        if(result.data.flag){
                            _this.findAll();
                        }else{
                            alert(result.data.msg);
                        }
                    })
                }
            }else{
                alert("请选择要删除的数据");
            }
        }
    },
    created:function () {
        this.findAll();
        this.getProList();
    }
});