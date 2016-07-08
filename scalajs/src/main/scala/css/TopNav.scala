package css

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object TopNav extends StyleSheet.Inline {

  import dsl._

  val navMenu = style(display.flex,
                      alignItems.center,
                      backgroundColor(c"#F2706D"),
                      margin.`0`,
                      listStyle := "none")

  val menuItem = styleF.bool(
      selected =>
        styleS(padding(20.px),
               fontSize(1.5.em),
               cursor.pointer,
               color(c"rgb(244, 233, 233)"),
               mixinIfElse(selected)(
                   backgroundColor(c"#E8433F"),
                   fontWeight._500)(&.hover(backgroundColor(c"#B6413E")))))

}
