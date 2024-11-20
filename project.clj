(defproject financials-front "1.0.0"
  :description "Front-end para Financials"
  :license {:name "Proprietary"}
  :source-paths ["src"]
  :test-paths ["test"]

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/clojurescript "1.11.60"]
                 [thheller/shadow-cljs "2.20.0"]
                 [reagent "1.1.1"]
                 [re-frame "1.4.2"]
                 [cljs-ajax "0.8.4"]
                 [day8.re-frame/http-fx "0.2.1"]
                 [metosin/reitit "0.7.2"]
                 [binaryage/devtools "1.0.6"]]

  :profiles {:dev {:plugins [[com.github.clojure-lsp/lein-clojure-lsp "1.3.17"]]
                   :dependencies [[day8.re-frame/tracing      "0.6.2"]
                                  [day8.re-frame/re-frame-10x "1.9.10"]]}}

  :aliases {"clean-ns" ["clojure-lsp" "clean-ns" "--dry"]
            "format" ["clojure-lsp" "format" "--dry"]
            "diagnostics" ["clojure-lsp" "diagnostics"]
            "lint" ["do" ["clean-ns"] ["format"] ["diagnostics"]]
            "clean-ns-fix" ["clojure-lsp" "clean-ns"]
            "format-fix" ["clojure-lsp" "format"]
            "lint-fix" ["do" ["clean-ns-fix"] ["format-fix"]]})
