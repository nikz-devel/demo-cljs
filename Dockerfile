FROM strategicblue/cljs-builder:latest as build

WORKDIR /build

COPY . .

RUN npx shadow-cljs release app


FROM python:3.12

WORKDIR /app

COPY --from=build /build/index.html .
COPY --from=build /build/public ./public

CMD ["python", "-m", "http.server"]
