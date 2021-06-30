package main

import ui.base.Screen

import model.*
import utils.Position
import input.InputBridge
import input.hardwareInput.InputId

object TitleScreenCreator {

  def create(inputBridge:InputBridge):Game = {
    val root = new Game(1600, 900)
    val play = new Button()
    play.text = "Play"
    play.highlight()
    val settings = new Button()
    settings.text = "Settings"
    settings.position = Position(0, 100)
    val quit = new Button()
    quit.position = Position(0, 200)
    quit.text = "Quit"
    root += play;
    root += settings;
    root += quit;
    val menu = new Menu(List(play, settings, quit))
    val down = inputBridge.newAbstractInput(Set(InputId.DpadVertical))
    var aux = System.currentTimeMillis;
    var reset = true
    inputBridge.registerObserver(down.id, d => {
      //  println(s"$d:$reset")
        if(d == 0){
          reset = true
        }
        if(d > 0 && (reset || System.currentTimeMillis - aux > 300)){
          reset = false
          aux = System.currentTimeMillis;
          menu.next()
        }
        if(d < 0 && (reset || System.currentTimeMillis - aux > 300)){
          reset = false
          aux = System.currentTimeMillis;
          menu.prev()
        }
    })
    root
  }
}
