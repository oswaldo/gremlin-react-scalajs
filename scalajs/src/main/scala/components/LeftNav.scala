package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js.{Any, UndefOr}
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import routes.Item

object LeftNav {

  case class Props(menus: Vector[Item],
                   selectedPage: Item,
                   ctrl: RouterCtl[Item])

  implicit val currentPageReuse = Reusability.by_==[Item]
  implicit val propsReuse = Reusability.by((_: Props).selectedPage)

  val component = ReactComponentB[Props]("LeftNav").render_P { P =>
    <.ul(css.LeftNav.container)(
      P.menus.map(
        item =>
          <.li(^.key := item.title,
               css.LeftNav.menuItem(item == P.selectedPage),
               item.title,
               P.ctrl setOnClick item))
    )
  }.configure(Reusability.shouldComponentUpdate).build

  def apply(props: Props, ref: UndefOr[String] = "", key: Any = {}) =
    component.set(key, ref)(props)

}
