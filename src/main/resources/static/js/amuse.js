/**
 * @author Liangcheng Juves
 * Created at 2020/05/14 16:57
 */
let doc = document


function docWrite(text) {
    doc.write(text);
}


function loadHeadCommon(title) {
    docWrite('<meta charset="UTF-8">' +
        '<meta name="viewport"content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">' +
        '<meta http-equiv="X-UA-Compatible"content="ie=edge">' +
        '<title>' + title + '</title>' +
        '<link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">' +
        '<link rel="shortcut icon" type="image/x-icon" href="/static/img/favicon.ico">')
}

function loadJQuery() {
    docWrite('<script src="https://code.jquery.com/jquery-3.5.1.js" ' +
        'integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" ' +
        'crossorigin="anonymous"></script>')
}

function loadJQueryMinified() {
    docWrite('<script src="https://code.jquery.com/jquery-3.5.1.min.js" ' +
        'integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" ' +
        'crossorigin="anonymous"></script>')
}

function loadJQuerySlim() {
    docWrite('<script src="https://code.jquery.com/jquery-3.5.1.slim.js" ' +
        'integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" ' +
        'crossorigin="anonymous"></script>')
}

function loadJQuerySlimMinified() {
    docWrite('<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ' +
        'integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" ' +
        'crossorigin="anonymous"></script>')
}

function loadVue() {
    docWrite('<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>')
}

function loadVueMinified() {
    docWrite('<script src="https://cdn.jsdelivr.net/npm/vue@2.6.11"></script>')
}


function loadBootstrap() {
    docWrite('<link rel="stylesheet" ' +
        'href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" ' +
        'integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" ' +
        'crossorigin="anonymous">' +
        '<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ' +
        'integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" ' +
        'crossorigin="anonymous"></script>')
}


function loadFullBootstrap() {
    loadBootstrap()
    docWrite('<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" ' +
        'integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" ' +
        'crossorigin="anonymous"></script>' +
        '<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ' +
        'integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" ' +
        'crossorigin="anonymous"></script>')
}