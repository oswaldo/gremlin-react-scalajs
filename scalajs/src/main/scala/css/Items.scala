package css

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object Items extends StyleSheet.Inline {
  import dsl._
  val container = style(
    display.flex,
    minHeight(600.px))

  val nav = style(width(190.px),
    borderRight :=! "1px solid rgb(223, 220, 220)")

  val content = style(padding(30.px))
}
