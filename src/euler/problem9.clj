(ns euler.problem9)

(defn square [n]
  (* n n))

(defn triplet [tuple]
   (let [u (first tuple) v (last tuple)]
      (list (- (square u) (square v)) (* 2 u v) (+ (square u) (square v)))))

(defn tuple [[f & r]]
   (let [u f v (first r) v1 (+ v 2)]
      (if (> u v1) (list u v1)
         (let [u1 (inc u)]
            (list u1 (if (even? u1) 1 2))))))

(defn tuples []
   (iterate tuple '(2 1)))

(defn calc [n]
   (apply * (first (filter #(= (apply + %) n) (map triplet (tuples))))))