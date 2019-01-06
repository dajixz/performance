function parent_add_tab(url,obj){
    title=$(obj).attr("name");
    id= $(obj).attr("lay-id");
    var tab_li = $("li[lay-id="+id+"]",parent.document)
    if(tab_li.length==1){
        parent.element.tabChange('xbs_tab', id)
    }
    else {
        parent.element.tabAdd('xbs_tab', {
            title: title,
            content: '<iframe tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="x-iframe"></iframe>',
            id: id
        })
        parent.element.tabChange('xbs_tab', id)
    }
}