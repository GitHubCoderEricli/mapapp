$(document).ready(function(){
    
})

/* 用于给页面绘制顶部信息的方法 */
function setHeader(title, discription, developStatus) {

    var insertString = new Array();

    if (null != title && "" != title) {
        insertString.push("<div class='header-container'>");
        insertString.push("<span class='header-title'>" + title + "</span>");
        insertString.push(" ");
    } else {
        alert("Please Fill Out the Title!");
        return;
    }

    if (null != discription && "" != discription) {
        insertString.push("<span class='header-discription'>" + discription + "</span>");
        insertString.push(" ");
    }

    if (null != developStatus && "" != developStatus) {
        insertString.push("<span class='header-developStatus'>" + developStatus + "</span>");
    }

    insertString.push("<div class='header-baseline'></div>");
    insertString.push("</div>");

    $("body").prepend(insertString.join(""));
}