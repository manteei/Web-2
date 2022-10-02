export const createPoint = (x, y) => {
    const node = document.createElement('div');

    node.classList.add('container-point');

    node.style.left = `${x}px`;
    node.style.top = `${y}px`;

    return node;
}

export function buildPoint(container, x, y, r){
    const x1 = container.getBoundingClientRect().left;
    const y1 = container.getBoundingClientRect().top;
    container.appendChild(createPoint(x1 + 185 + 413/(3 * r) * x, y1 + 185 - 378/(3*r)*y));
}
