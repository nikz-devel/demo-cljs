FROM strategicblue/cljs-builder:latest as build
WORKDIR /build
COPY . .
RUN npm install
RUN npm run release

FROM python:3.12
WORKDIR /app
COPY --from=build /build/resources .
CMD ["python", "-m", "http.server"]
