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

### 1. Pertenencia

\[
\operatorname{pertenece}(x, S) = S(x)
\]

Devuelve el grado de pertenencia del elemento \( x \) al conjunto difuso \( S \).

### 2. Conjunto Difuso "Grande"

Genera un conjunto difuso que modela el concepto de “números grandes”.

\[
\operatorname{grande}(d, e)(x) =
\begin{cases}
0 & \text{si } x \leq 0 \\
\left(\frac{x}{x + d}\right)^e & \text{si } x > 0
\end{cases}
\]

Donde:
- \( d > 0 \) controla la pendiente de crecimiento.
- \( e > 0 \) controla la forma de la curva.
- A medida que \( x \to \infty \), \( f_{d,e}(x) \to 1 \).

### 3. Complemento de un Conjunto Difuso

\[
\operatorname{complemento}(S)(x) = 1 - S(x)
\]

Representa el grado de **no pertenencia** de \( x \) al conjunto \( S \).

### 4. Unión de Conjuntos Difusos

\[
\operatorname{union}(S_1, S_2)(x) = \max
\left( S_1(x), S_2(x) \right)
\]

Representa el grado de pertenencia de \( x \) al conjunto que resulta de la unión de \( S_1 \) y \( S_2 \).

### 5. Intersección de Conjuntos Difusos

\[
\operatorname{interseccion}(S_1, S_2)(x) = \min
\left( S_1(x), S_2(x) \right)
\]

Representa el grado de pertenencia de \( x \) al conjunto que resulta de la intersección de \( S_1 \) y \( S_2 \).

### 6. Inclusión de Conjuntos Difusos

\[
\operatorname{inclusion}(S_1, S_2) = \forall x
\left( S_1(x) \leq S_2(x) \right)
\]

Indica si el conjunto difuso \( S_1 \) está incluido en \( S_2 \) para todos los elementos del universo de discurso.

### 7. Igualdad de Conjuntos Difusos

\[
\operatorname{igualdad}(S_1, S_2) = \forall x
\left( S_1(x) = S_2(x) \right)
\]

Indica si los conjuntos difusos \( S_1 \) y \( S_2 \) son iguales para todos los elementos del universo de discurso.

