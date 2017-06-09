/**
 * Created by Administrator on 2016/4/28.
 */
$(document).ready(function(){
    $.ajax({
        url:'/user/list.do',
        dataType:'json',
        async:true,
        success:function(data){
            new Vue({
                el: '#ulist',
                data: {
                    userList: data
                }
            });
        }
    });
});

