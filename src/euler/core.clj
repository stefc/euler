(ns euler.core
	(:gen-class)
	(:require [euler.problem1])
	(:require [euler.problem2])
	(:require [euler.problem3])
	(:require [euler.problem4])
	(:require [euler.problem5])
	(:require [euler.problem6])
	(:require [euler.problem7])
	(:require [euler.problem8])
	(:require [euler.problem10])
	(:require [euler.problem37])
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
 	(time(println (format "Problem No %d = %d" 6 (euler.problem6/calc 100))))
 	(time(println (format "Problem No %d = %d" 7 (euler.problem7/calc 10001))))
 	(time(println (format "Problem No %d = %d" 8 (euler.problem8/calc 5))))
 	(time(println (format "Problem No %d = %d" 10 (euler.problem10/calc 2e6))))
 	(time(println (format "Problem No %d = %d" 37 (euler.problem37/calc 11))))
  )
