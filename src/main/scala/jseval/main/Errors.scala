package jseval.main

trait Errors {
  import org.bitbucket.inkytonik.kiama.util.Positions
  import jseval.parser.JSSyntax.ASTNode

  object Posns extends Positions

  type Position = Object

  class InterpreterException(s: String) extends Exception(s)

  def error(t: ASTNode, s: String): Nothing = {
    Posns.getStart(t) match {
      case Some(p) =>
        throw new InterpreterException(p.format + " " + s)
      case None =>
        throw new InterpreterException(s)
    }
  }

  def error(s: String): Nothing = {
    throw new InterpreterException(s)
  }

  def unimplemented: Nothing = {
    error("unimplemented")
  }
}
