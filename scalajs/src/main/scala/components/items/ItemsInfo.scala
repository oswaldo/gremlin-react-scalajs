package components.items

import japgolly.scalajs.react.{ReactComponentB, _}
import japgolly.scalajs.react.vdom.prefix_<^._

object ItemsInfo {

  val component =
    ReactComponentB.static("ItemsInfo", <.div(" Items Root Page  ")).build

  def apply() = component()
}
