(ns euler.core
  (:gen-class))

; Multiples of 3 and 5
; 
; Multiplier bestimmen
; Filter Funktion
; Reduce zum Aufsummieren
;
(defn no1 [n]
	(reduce + (filter (fn [x] (or 
			(zero? (mod x 5))
			(zero? (mod x 3))))
		(range n))))


; Even Fibonacci numbers

; Lazy-Seq / take-while / filter / even-numbers

(defn no2 [n] 
	(letfn [(fib [a b] (cons a (lazy-seq (fib b (+ b a)))))]
		(reduce + (take-while (fn [x] (< x n)) (filter even? (fib 1 2))))))

(defn -main [& args]
 	(time(println (format "Problem No %d = %d" 1 (no1 1e3))))
 	(time(println (format "Problem No %d = %d" 2 (no2 4e6))))
  )
