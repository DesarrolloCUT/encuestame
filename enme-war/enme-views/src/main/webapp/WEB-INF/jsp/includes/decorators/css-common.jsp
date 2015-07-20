<style>
article,aside,details,figcaption,figure,footer,header,hgroup,main,nav,section,summary{display:block}
audio,canvas,video{display:inline-block}
audio:not([controls]){display:none;height:0}
[hidden]{display:none}
html{font-family:sans-serif;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}
a:focus{outline:thin dotted}
a:active,a:hover{outline:0}
h1{font-size:2em;margin:.67em 0}
abbr[title]{border-bottom:1px dotted}
b,strong{font-weight:bold}
dfn{font-style:italic}
hr{-moz-box-sizing:content-box;box-sizing:content-box;height:0}
mark{background:#ff0;color:#000}
code,kbd,pre,samp{font-family:monospace, serif;font-size:1em}
pre{white-space:pre-wrap}
q{quotes:\201C \201D \2018 \2019}
small{font-size:80%}
sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}
sup{top:-.5em}
sub{bottom:-.25em}
img{border:0}
svg:not(:root){overflow:hidden}
fieldset{border:1px solid #c0c0c0;margin:0 2px;padding:.35em .625em .75em}
button,input,select,textarea{font-family:inherit;font-size:100%;margin:0}
button,input{line-height:normal}
button,select{text-transform:none}
button,html input[type=button],/* 1 */
input[type=reset],input[type=submit]{-webkit-appearance:button;cursor:pointer}
button[disabled],html input[disabled]{cursor:default}
input[type=checkbox],input[type=radio]{box-sizing:border-box;padding:0}
input[type=search]{-webkit-appearance:textfield;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;box-sizing:content-box}
input[type=search]::-webkit-search-cancel-button,input[type=search]::-webkit-search-decoration{-webkit-appearance:none}
textarea{overflow:auto;vertical-align:top}
table{border-collapse:collapse;border-spacing:0}
body,figure{margin:0}
legend,button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}
</style>
<c:if test="${development}">
    <link type="text/css" rel="<c:url value="stylesheet${development ? '' : ''}" />"  href="<c:url value="/resources/css/${development ? 'pages' : 'pages'}/${detectedDevice ? 'mobile_' : ''}${cssFile}.${development ? 'css' : 'min.css'}" />" />
</c:if>
<link rel="stylesheet"  href="<c:url value="/resources/css/commons/font-awesome.min.css" />" />