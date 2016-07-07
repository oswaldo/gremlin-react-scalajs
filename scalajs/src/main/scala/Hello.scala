import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import org.scalajs.dom
import scalatags.JsDom.all._
import shared.SharedMessages
import css.AppCSS
import routes.AppRouter

object Hello extends js.JSApp {
  
  def main(): Unit = {
    AppCSS.load
    AppRouter.router().render(dom.document.body)
    if (!js.isUndefined(global.window.console)) {
      global.console.log("Welcome to your Play application's JavaScript!");
    }

    dom.document
      .getElementById("scalajsclientDiv")
      .appendChild(
        ul(li("ScalaJS shouts out: ", em(SharedMessages.itWorks))).render)

  }
  
}
