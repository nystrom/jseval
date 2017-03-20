# JSEval

This is a small toy JS interpreter used for teaching programming languages.

## Building

Install Scala 2.11 and the Scala Build Tool (`sbt`).

With Homebrew on a Mac:

    brew install scala
    brew install sbt

Other systems are left as an exercise to the reader.

To build:

    sbt compile

## Running

To run the REPL:

    sbt "run-main jseval.main.Interpreter"

This should print "unimplemented" for most expressions you type in.

## Completing eval

You can fill in the implementation of `eval(Exp)(Env)` in:

    src/main/scala/jseval/main/Eval.scala

The grammar and AST classes are defined in:

    src/main/scala/jseval/parser/JS.syntax

After building, the generated AST classes in:

    target/scala-2.11/src_managed/main/sbt-rats/jseval/parser/JSSyntax.scala
