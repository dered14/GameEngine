package model

import utils.Position

class Menu(buttons:List[Button]) {

    assert(!buttons.isEmpty)
    buttons(0).highlight()

    private var index = 0;

    def next():Unit = {
        buttons(index).removeHighlight()
        index = utils.Math.zeroOrPositiveModulo(index + 1, buttons.size)
        buttons(index).highlight()
    }

    def prev():Unit = {
        buttons(index).removeHighlight()
        index = utils.Math.zeroOrPositiveModulo(index - 1, buttons.size)
        buttons(index).highlight()
    }
}