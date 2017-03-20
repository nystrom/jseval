package jseval.main

object Eval {
  import jseval.parser.JSSyntax._
  import jseval.parser.JSPrettyPrinter
  import jseval.main.{Interpreter => Errors}

  type Env = Map[String, Value]

  sealed trait Value
  case class FunValue(params: List[String], body: Exp) extends Value {
    override def toString = "function " + params.mkString("(", ", ", ")") + " { return " + JSPrettyPrinter.show(body) + "; }"
  }
  case class NumValue(value: Double) extends Value {
    override def toString = value.toString
  }
  case class UndefinedValue() extends Value {
    override def toString = "undefined"
  }

  def eval(e: Exp)(env: Env): Value = e match {
    // e1 || e2
    case Or(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 && e2
    case And(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 == e2
    case Eq(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 != e2
    case Ne(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 === e2
    case StrictEq(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 !== e2
    case StrictNe(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 < e2
    case Lt(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 <= e2
    case Le(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 > e2
    case Gt(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 >= e2
    case Ge(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 + e2
    case Add(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 - e2
    case Sub(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 * e2
    case Mul(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 / e2
    case Div(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // e1 % e2
    case Mod(e1: Exp, e2: Exp) =>
      Errors.unimplemented
      
    // - e
    case Neg(e: Exp) =>
      Errors.unimplemented
      
    // ! e
    case Not(e: Exp) =>
      Errors.unimplemented
      
    // double literal
    case Num(value) =>
      Errors.unimplemented
      
    // true
    case True() =>
      Errors.unimplemented
      
    // false
    case False() =>
      Errors.unimplemented
      
    // variable name
    case Var(name) =>
      Errors.unimplemented
      
    // function (x, y, z) { return x + y + z; }
    case Function(paramNames: List[String], body: Exp) =>
      Errors.unimplemented
      
    // f(1, 2, 3)
    case Call(fun: Exp, args: List[Exp]) =>
      Errors.unimplemented
      
    // undefined
    case Undefined() =>
      UndefinedValue()
  }
}
