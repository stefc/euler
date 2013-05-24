(ns euler.core
  (:gen-class))

; Multiples of 3 and 5
; 
; Multiplier bestimmen
; Filter Funktion
; Reduce zum Aufsummieren
;
(defn no1 [n] ; 6.3 msec
	(apply + (filter (fn [x] (or 
			(zero? (mod x 5))
			(zero? (mod x 3))))
		(range n))))

; Smarter but very slow ?
;(defn no1 [n]
;	(letfn [(where [x] ( eval (cons 'or (map (fn [y] (zero? (mod x y))) '(3 5)))))  ]	
;   		(apply + (filter where (range n)))))

; Even Fibonacci numbers

; Lazy-Seq / take-while / filter / even-numbers

;(defn no2 [n] ; 1.5 msec
;	(letfn [(fib [a b] (cons a (lazy-seq (fib b (+ b a)))))]
;		(apply + (take-while (fn [x] (< x n)) (filter even? (fib 1 2))))))

(defn no2 [n] 
   (apply + (take-while (fn [v] (< v n)) (filter even? (map first (iterate (fn [[a b]] [b (+ a b)]) [1 2]))))))

(defn -main [& args]
 	(time(println (format "Problem No %d = %d" 1 (no1 1e3))))
 	(time(println (format "Problem No %d = %d" 2 (no2 4e6))))
  )
