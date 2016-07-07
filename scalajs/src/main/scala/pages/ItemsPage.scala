package pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import components.LeftNav
import routes.Item

object ItemsPage {
  
  val component = ReactComponentB[Props]("ItemsPage")
    .render_P { P =>
      <.div(css.Items.container,
        <.div(css.Items.nav, LeftNav(LeftNav.Props(Item.menu,P.selectedPage,P.ctrl))),
        <.div(css.Items.content, P.selectedPage.render())
      )
    }
    .build

  case class Props(selectedPage : Item,ctrl : RouterCtl[Item])

  def apply(props : Props,ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(props)

}