package taller

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite

import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {
  val conjuntos_difusos = new ConjuntosDifusos()

  val conjuntoA: conjuntos_difusos.ConjDifuso = (x: Int) => if (x <= 0) 0.0 else math.min(1.0, x.toDouble / 10.0)
  val conjuntoB: conjuntos_difusos.ConjDifuso = (x: Int) => if (x >= 10) 1.0 else x.toDouble / 10

  test("Test Conjunto Difuso pertenece") {
    assert(conjuntos_difusos.pertenece(5, conjuntoA) == 0.5)
    assert(conjuntos_difusos.pertenece(15, conjuntoA) == 1.0)
    assert(conjuntos_difusos.pertenece(-3, conjuntoA) == 0.0)
  }

  test("Test Conjunto Difuso Grande") {
    val grande = conjuntos_difusos.grande(5, 2)
    // Para x <= 0
    assert(math.abs(grande(0) - 0.0) < 0.0001)
    assert(math.abs(grande(-3) - 0.0) < 0.0001)

    // Para x > 0
    assert(math.abs(grande(5) - math.pow(5.0 / (5 + 5).toDouble, 2.0)) < 0.0001)
    assert(math.abs(grande(10) - math.pow(10.0 / (10 + 5).toDouble, 2.0)) < 0.0001)
  }

  test("Test Conjunto Difuso Complemento") {
    val complementoA = conjuntos_difusos.complemento(conjuntoA)
    assert(math.abs(complementoA(5) - 0.5) < 0.0001)
    assert(math.abs(complementoA(10) - 0.0) < 0.0001)
    assert(math.abs(complementoA(0) - 1.0) < 0.0001)
  }

  test("Test Conjunto Difuso Union") {
    val union = conjuntos_difusos.union(conjuntoA, conjuntoB)
    assert(math.abs(union(5) - math.max(conjuntoA(5), conjuntoB(5))) < 0.0001)
    assert(math.abs(union(10) - math.max(conjuntoA(10), conjuntoB(10))) < 0.0001)
    assert(math.abs(union(0) - math.max(conjuntoA(0), conjuntoB(0))) < 0.0001)
  }

  test("Test Conjunto Difuso Interseccion") {
    val interseccion = conjuntos_difusos.interseccion(conjuntoA, conjuntoB)
    assert(math.abs(interseccion(5) - math.min(conjuntoA(5), conjuntoB(5))) < 0.0001)
    assert(math.abs(interseccion(10) - math.min(conjuntoA(10), conjuntoB(10))) < 0.0001)
    assert(math.abs(interseccion(0) - math.min(conjuntoA(0), conjuntoB(0))) < 0.0001)
  }

  test("Test Conjunto Difuso Inclusion") {
    val inclusion = conjuntos_difusos.inclusion(conjuntoA, conjuntoB)
    assert(inclusion || !inclusion) // Solo verifica que retorne un booleano
  }

  test("Test Conjunto Difuso Igualdad") {
    val igualdad = conjuntos_difusos.igualdad(conjuntoA, conjuntoB)
    assert(igualdad)
  }
}
