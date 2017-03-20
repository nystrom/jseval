package jseval.main

import org.bitbucket.inkytonik.kiama.util.{REPL, REPLConfig, Source, Console, Positions}
import jseval.parser.JSSyntax.ASTNode
import jseval.parser.JSSyntax.Exp
import jseval.parser.JS
import jseval.parser.JSPrettyPrinter

object Interpreter extends REPL with Errors {
  val banner = "Welcome to the my little JS interpreter!"

  override val prompt = "JS> "

  def processline(source: Source, console: Console, config: REPLConfig): Option[REPLConfig] = {
    if (config.processWhitespaceLines() || (source.content.trim.length != 0)) {
      val p = new JS(source, Posns)
      val result = p.pRoot(0)

      if (result.hasValue) {
        result.semanticValue[ASTNode] match {
          case t: Exp =>
            config.output().emitln("parsed: " + JSPrettyPrinter.show(t))
            config.output().emitln("ast: " + t)
            process(source, t, config)
          case _ =>
            config.output().emitln(p.formatParseError(result.parseError, true))
        }
      }
      else {
        config.output().emitln(p.formatParseError(result.parseError, true))
      }
    }

    Some(config)
  }

  def process(source: Source, e: Exp, config: REPLConfig) {
    try {
      val p = jseval.main.Eval.eval(e)(Map())
      config.output().emitln(p)
    }
    catch {
      case ex: InterpreterException => config.output().emitln(ex.getMessage)
    }
  }
  //
  // override def main(args: Array[String]): Unit = {
  //   import java.io._
  //   import org.bitbucket.inkytonik.kiama.util.FileSource
  //
  //   if (args.length == 0) {
  //     super.main(args)
  //   }
  //   else {
  //     val sourceName = args(0)
  //     try {
  //       val src = FileSource(sourceName)
  //       try {
  //         val p = new JS(src, Posns)
  //         val result = p.pRoot(0)
  //         if (result.hasValue) {
  //           result.semanticValue[ASTNode] match {
  //             case t: Exp =>
  //               val p = jseval.main.Eval.eval(t)(Map())
  //               println(p)
  //             case _ =>
  //               println(p.formatParseError(result.parseError, true))
  //           }
  //         }
  //         else {
  //           println(p.formatParseError(result.parseError, true))
  //         }
  //       }
  //       catch {
  //         case e: IOException => println(e.getMessage)
  //       }
  //     }
  //     catch {
  //       case e: IOException => println(e.getMessage)
  //     }
  //   }
  // }
}
