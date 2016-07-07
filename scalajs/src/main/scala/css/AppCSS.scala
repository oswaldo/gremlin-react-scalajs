package css

import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry
import scalacss.Defaults._

object AppCSS {

  def load = {
    GlobalRegistry.register(
      GlobalStyle,
      TopNav,
      LeftNav,
      Items,
      Home)
    GlobalRegistry.onRegistration(css => css.addToDocument)
  }
}