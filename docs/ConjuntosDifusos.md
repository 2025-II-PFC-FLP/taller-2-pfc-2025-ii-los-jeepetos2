# Taller — Conjuntos Difusos (Documentación Técnica)

## Definicion del codigo 

```scala
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
    (x: Int) => math.min(cd1(x), cd2(x))
  }
  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    val universo_discurso = 0 to 10
    universo_discurso.forall(x => cd1(x) <= cd2(x))
  }
  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    val universo_discurso = 0 to 10
    universo_discurso.forall(x => cd1(x) == cd2(x))
  }
}
```

## Definiciones matemáticas

### 1. Conjunto Difuso "Grande"

Genera un conjunto difuso que modela el concepto de “números grandes”.

$$
f_{d,e}(n) = \left(\frac{n}{n + d}\right)^e, \quad n \in \mathbb{Z},\ d \ge 1,\ e > 0
$$

Donde:
- \( d > 0 \) controla la pendiente de crecimiento.
- \( e > 0 \) controla la forma de la curva.

### 2. Complemento de un Conjunto Difuso

$$
f_{\neg S}(x) = 1 - f_S(x)
$$

Representa el grado de **no pertenencia** de \( x \) al conjunto \( S \).

### 3. Unión de Conjuntos Difusos

$$
f_{S_1\cup S_2}(x) = \max(f_{S_1}(x), f_{S_2}(x))
$$

Representa el grado de pertenencia de \( x \) al conjunto que resulta de la unión de \( S_1 \) y \( S_2 \).

### 4. Intersección de Conjuntos Difusos

$$
f_{S_1\cap S_2}(x) = \min(f_{S_1}(x), f_{S_2}(x))
$$

Representa el grado de pertenencia de \( x \) al conjunto que resulta de la intersección de \( S_1 \) y \( S_2 \).

### 5. Inclusión de Conjuntos Difusos

$$
S_1 \subseteq S_2 \iff \forall x \in U,\ f_{S_1}(x) \le f_{S_2}(x)
$$

Indica si el conjunto difuso \( S_1 \) está incluido en \( S_2 \) para todos los elementos del universo de discurso.

### 6. Igualdad de Conjuntos Difusos

$$
S_1 = S_2 \iff S_1 \subseteq S_2 \land S_2 \subseteq S_1
$$

Indica si los conjuntos difusos \( S_1 \) y \( S_2 \) son iguales para todos los elementos del universo de discurso.

