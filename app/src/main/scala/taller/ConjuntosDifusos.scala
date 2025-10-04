package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }
  def grande(d: Int, e: Int): ConjDifuso = {
    (x: Int) => {
      if (x <= 0) 0.0
      else math.pow(x.toDouble / (x + d).toDouble, e.toDouble)
    }
  }
  def complemento(c: ConjDifuso): ConjDifuso = {
    (x: Int) => 1.0 - c(x)
  }
  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    (x: Int) => math.max(cd1(x), cd2(x))
  }
  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    // Implementación de la función intersección

  }
  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    // Implementación de la función inclusión

  }
  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    // Implementación de la función igualdad

  }
}
