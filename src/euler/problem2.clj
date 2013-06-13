(ns euler.problem2)

; Even Fibonacci numbers

; Lazy-Seq / take-while / filter / even-numbers

; E(n)=4*E(n-1)+E(n-2).
(defn calc [n] 
   (apply + (take-while #(< % n) (map first (iterate (fn [[a b]] [b (+ (* 4 b) a)]) [2 8])))))

[23 3]
2543
[1000 2543] [100 543] [10 43] [1 3]

(int (/ 23 10) int(/ 3 1)  )