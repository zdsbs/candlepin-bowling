(ns all-tests
  (:use clojure.contrib.test-is 
	clojure.contrib.find-namespaces
	clojure.contrib.str-utils)
  (import (java.io File))
)

(def current-dir (new java.io.File "./candlepin-bowling"))

(defn is-test-file? [file]
	(not (nil? (re-find #"test$" (. file getName)))))

(defn find-test-namespaces [file]
	(filter is-test-file? (find-namespaces-in-dir file)))

(println "ALL TEST FILES")
(doseq [file (find-test-namespaces current-dir)]
	(use file))

(apply run-tests (find-test-namespaces current-dir))


