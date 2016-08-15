package secondNewTry

/**
  * Created by buck on 7/31/16.
  */

abstract class FunctionExpr {
  def properties: Set[String] = this match {
    case UnderscoreFunctionExpr => Set()
    case NamedFunctionExpr(name) => {
      // TODO this is wrong I think. This needs to be passed the properties of the function
      Set()
    }
    case AnonymousFunctionExpr(defaultProperties, rhs) => {
      // TODO does this also need to take into account properties known in the local scope? I don't think so.
      defaultProperties
    }
  }
}

case object UnderscoreFunctionExpr extends FunctionExpr
case class NamedFunctionExpr(name: String) extends FunctionExpr
case class AnonymousFunctionExpr(defaultProperties: Set[String], rhs: ImplRhs) extends FunctionExpr
