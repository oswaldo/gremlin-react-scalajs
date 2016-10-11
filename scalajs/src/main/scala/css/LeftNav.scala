package css

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object LeftNav extends StyleSheet.Inline {

  import dsl._

  val container =
    style(display.flex, flexDirection.column, listStyle := "none", padding.`0`)

  val menuItem = styleF.bool(
    selected =>
      styleS(lineHeight(48.px),
             padding :=! "0 25px",
             cursor.pointer,
             textDecoration := "none",
             mixinIfElse(selected)(color.red, fontWeight._500)(
               color.black,
               &.hover(color(c"#555555"), backgroundColor(c"#ecf0f1")))))

}
