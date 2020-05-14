/**
 * @author Liangcheng Juves
 * Created at 2020/05/14 16:57
 */
let doc = document


function docWrite(text) {
    doc.write(text);
}


function scriptOf(src) {
    docWrite('<script src="' + src + '"></script>')
}

function scriptAsyncOf(src) {
    docWrite('<script async src="' + src + '"></script>')
}


function writeHeadCommon(title) {
    docWrite('<meta charset="UTF-8">' +
        '<meta name="viewport"content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">' +
        '<meta http-equiv="X-UA-Compatible"content="ie=edge">' +
        '<title>' + title + '</title>' +
        '<link rel="icon"type="image/x-icon"href="/static/img/favicon.ico">' +
        '<link rel="shortcut icon"type="image/x-icon"href="/static/img/favicon.ico">')
}

function loadJQuery() {

}