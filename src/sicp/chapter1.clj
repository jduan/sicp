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

;; 1.1.7 square roots by Newton's method
(defn square-root [x]
  (letfn [(abs [x]
            (if (> x 0)
              x
              (- 0 x)))
          (square-root-internal [guess]
            (if (good-enough? guess)
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
