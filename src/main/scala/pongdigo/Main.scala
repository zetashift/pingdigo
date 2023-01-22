package pongdigo

import org.scalajs.dom
import indigo.*
import scala.scalajs.js.annotation.JSExportTopLevel
import indigo.IndigoSandbox

case class Player(position: Point)
case class CPU(position: Point)
case class Ball(velocity: Double, direction: Point)
case class Score(leftScore: Int, rightScore: Int)

case class PongGame(
    paddleLeft: Player,
    paddleRight: CPU,
    ball: Ball,
    score: Score
)

@JSExportTopLevel("IndigoGame")
object HelloIndigo extends IndigoSandbox[Unit, Unit]:

  val config: GameConfig =
    GameConfig.default

  val animations: Set[Animation] =
    Set()

  val assets: Set[AssetType] =
    Set()

  val fonts: Set[FontInfo] =
    Set()

  val shaders: Set[Shader] =
    Set()

  def setup(
      assetCollection: AssetCollection,
      dice: Dice
  ): Outcome[Startup[Unit]] =
    Outcome(Startup.Success(()))

  def initialModel(startupData: Unit): Outcome[Unit] =
    Outcome(())

  def updateModel(
      context: FrameContext[Unit],
      model: Unit
  ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(())

  def present(
      context: FrameContext[Unit],
      model: Unit
  ): Outcome[SceneUpdateFragment] =
    Outcome(
      SceneUpdateFragment.empty
    )

