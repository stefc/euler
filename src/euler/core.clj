(ns euler.core
	(:gen-class)
	(:require [euler.problem1])
	(:require [euler.problem2])
	(:require [euler.problem3])
	(:require [euler.problem4])
	(:require [euler.problem5])
)

; Smarter but very slow ?
;(defn no1 [n]
;	(letfn [(where [x] ( eval (cons 'or (map (fn [y] (zero? (mod x y))) '(3 5)))))  ]	
;   		(apply + (filter where (range n)))))

(defn -main [& args]
 	(time(println (format "Problem No %d = %d" 1 (euler.problem1/calc 1e3))))
 	(time(println (format "Problem No %d = %d" 2 (euler.problem2/calc 4e6))))
 	(time(println (format "Problem No %d = %d" 3 (euler.problem3/calc 600851475143))))
 	(time(println (format "Problem No %d = %d" 4 (euler.problem4/calc 3))))
 	(time(println (format "Problem No %d = %d" 5 (euler.problem5/calc 20))))
  )
