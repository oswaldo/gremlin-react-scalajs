package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import models.Menu
import routes.AppRouter.AppPage

object TopNav {

  case class Props(menus: Vector[Menu],
                   selectedPage: AppPage,
                   ctrl: RouterCtl[AppPage])

  implicit val currentPageReuse = Reusability.by_==[AppPage]
  implicit val propsReuse = Reusability.by((_: Props).selectedPage)

  val component = ReactComponentB[Props]("TopNav").render_P { P =>
    <.header(
      <.nav(
        <.ul(css.TopNav.navMenu,
             P.menus.map(
               item =>
                 <.li(^.key := item.name,
                      css.TopNav.menuItem(
                        item.route.getClass == P.selectedPage.getClass),
                      item.name,
                      P.ctrl setOnClick item.route)))
      )
    )
  }.configure(Reusability.shouldComponentUpdate).build

  def apply(props: Props, ref: js.UndefOr[String] = "", key: js.Any = {}) =
    component.set(key, ref)(props)

}
