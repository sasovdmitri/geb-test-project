package modules

import geb.Module

class MessageModule extends Module {
    static content = {
        footerMessage {$("#MessageSubscribeOverlay")}
        footerCloseBtn {footerMessage.find(".footer-overlay__close")}
    }
}
