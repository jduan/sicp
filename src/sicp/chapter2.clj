(ns sicp.chapter2)

(defn gcd [x y]
  (letfn [(helper [small big]
            (if (zero? small) big
              (helper (rem big small) small)))]
    (let [small (if (<= x y) x y)
          big (if (<= x y) y x)]
      (helper small big))))

(defn make-rat [x y]
  (let [g (gcd x y)]
    (list (/ x g) (/ y g))))

(defn numer [rational]
  (first rational))

(defn denom [rational]
  (second rational))

(defn print-rat [rational]
  (do
    (print (numer rational))
    (print "/")
    (println (denom rational))))

(defn add-rat [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat (* (numer x) (denom y))
            (* (denom x) (numer y))))

(defn equal-rat? [x y]
  (= (* (numer x) (denom y))
     (* (numer y) (denom x))))

;; Exercise 2.1
(defn abs [x]
     (if (> x 0) x (- x)))

(defn make-rat2 [x y]
  (if (>= (* x y) 0)
    (make-rat (abs x) (abs y))
    (make-rat (- 0 (abs x)) (abs y))))
