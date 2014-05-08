(ns sicp.chapter1)

(defn sum-of-squares-of-two-largest [& args]
  (letfn [(square [x] (* x x))
          (largest [xs] (take 2 (reverse (sort xs))))]
    (apply + (map square (largest args)))))

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(defn p []
  (p))
;; mytest isn't a special form so clojure doesn't know internally it uses an
;; "if" form. So it evaluates its parameters x and y first then evalute its body
;; with x and y
(defn mytest [x y]
  (if (= x 0) 0 y))

;; 1.1.6 new-if
;; The new form of "new-if" is implemented as a regular procedure. Regular
;; procedures use the "applicative-order" evaluation. In this case,
;; square-root-internal will be called over and over again.
(defn square-root2 [x]
  (letfn [(new-if [pred then-clause else-clause]
            (cond pred then-clause
                  :else else-clause))
          (abs [x]
            (if (> x 0) x (- x)))
          (square-root-internal [guess]
            (new-if (good-enough? guess)
              guess
              (square-root-internal (improve-guess guess))))
          (improve-guess [guess]
            (average guess (/ x guess)))
          (average [a b]
            (/ (+ a b) 2.0))
          (good-enough? [guess]
            (< (abs (- (* guess guess) x)) 0.001))
          ]
    (square-root-internal 1)))

;; 1.1.7 square roots by Newton's method
(defn square-root [x]
  (letfn [(abs [x]
            (if (> x 0) x (- x)))
          (square-root-internal [guess]
            (if (good-enough? guess)
              guess
              (square-root-internal (improve-guess guess))))
          (improve-guess [guess]
            (average guess (/ x guess)))
          (average [a b]
            (/ (+ a b) 2.0))
          (good-enough? [guess]
            (< (/ (abs (- (* guess guess) x)) x) 0.00000000000001))]
    (square-root-internal 1)))
