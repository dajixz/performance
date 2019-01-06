layui.use(['layer', 'form', 'laydate', 'upload'], function () {
    var layer = layui.layer, form = layui.form, laydate = layui.laydate, upload = layui.upload;
    laydate.render({
        elem: '#awardTime' //指定元素
    });
    laydate.render({
        elem:'#year',
        type:'year',
        value:new Date()
    })
    var fileListView = $('#filelist'),
        uploadListIns = upload.render({
            elem: '#upload'
            , url: '/upload'
            , accept: 'file'
            , data: {}   //可放扩展数据  key-value
            , multiple: true
            , auto: false
            , bindAction: '#testListAction'
            , choose: function (obj) {
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function (index, file, result) {
                    var tr = $(['<tr id="upload-' + index + '">'
                        , '<td>' + file.name + '</td>'
                        , '<td>等待上传</td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
                        , '</td>'
                        , '</tr>'].join(''));
                    // //单个重传
                    // tr.find('.demo-reload').on('click', function(){
                    //     obj.upload(index, file);
                    // });
                    //删除
                    tr.find('.demo-delete').on('click', function () {
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });
                    fileListView.append(tr);
                });
            }
            , done: function (res, index, upload) {
                if (res.code == 200) {//上传成功
                    var tr = fileListView.find('tr#upload-' + index)
                        , tds = tr.children();
                    tds.eq(1).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(2).html(''); //清空操作
                    $("#form").append("<input name=\"supportingUrlList[]\" value=\""+res.data+"\" hidden/>");
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
            } //code为后台传回来的数据，具体多少自己定，
            //后台只能传回json格式数据，不然会走error函数；
            , error: function (index, upload) {
                console.log("index:" + index)
                console.log("upload:" + upload)
            }
        });
    form.on('submit(add)', function (data) {
        console.log(data.field);
        //发异步，把数据提交给php
        return false;
    });
})
function add_inline() {
    var inline_div=$("#inline");
    var body="<div>\n" +
        "            <div class=\"layui-inline\">\n" +
        "                <label>成员工号</label>\n" +
        "                <div class=\"layui-input-inline\">\n" +
        "                    <input type=\"text\" name=\"awardUserIdList[]\" class=\"layui-input\">\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"layui-inline\">\n" +
        "                <label>成员姓名</label>\n" +
        "                <div class=\"layui-input-inline\">\n" +
        "                    <input type=\"text\" name=\"awardUserNameList[]\" class=\"layui-input\">\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"layui-inline\">\n" +
        "                <label>成员单位</label>\n" +
        "                <div class=\"layui-input-inline\">\n" +
        "                    <input type=\"text\" name=\"awardUserUnitList[]\" class=\"layui-input\">\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <a href=\"javascript:;\" onclick=\"remove_inline(this)\"><i class=\"layui-icon layui-icon-close\"></i></a>\n" +
        "        </div>";
    inline_div.append(body);
}
function remove_inline(obj) {
    $(obj).parent().remove();
}
