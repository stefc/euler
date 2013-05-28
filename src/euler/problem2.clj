(ns euler.problem2)

; Even Fibonacci numbers

; Lazy-Seq / take-while / filter / even-numbers

(defn calc [n] 
   (apply + (take-while #(< % n) (filter even? (map first (iterate (fn [[a b]] [b (+ a b)]) [1 2]))))))
